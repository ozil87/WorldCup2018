package com.m2team.worldcup.qualifiers.group.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;

import com.m2team.worldcup.R;
import com.m2team.worldcup.common.Common;
import com.m2team.worldcup.model.Group;
import com.m2team.worldcup.qualifiers.group.GroupQualifierAdapter;
import com.m2team.worldcup.qualifiers.group.OnDataCompleteListener;
import com.m2team.worldcup.qualifiers.group.presenter.QualifierPresenter;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AsiaQualifierFragment extends Fragment implements OnDataCompleteListener {

    private static final String ARG_POSITION = "position";

    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    GroupQualifierAdapter expandableListAdapter;
    private int position;

    public static AsiaQualifierFragment newInstance(int position) {
        AsiaQualifierFragment f = new AsiaQualifierFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        QualifierPresenter presenter = new QualifierPresenter(getActivity(), Common.ASIA_QUALIFIER_LINK);
        presenter.setOnDataComplete(this);
        presenter.getData(Common.ASIA_GROUPS_QUALIFIER, Common.ONE_DAY_IN_MILLISECONDS);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_group, null);
        ButterKnife.bind(this, view);

        expandableListAdapter = new GroupQualifierAdapter(getActivity());
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                return false;
            }
        });
        return view;
    }

    @Override
    public void updateView(List<Group> groups) {
        if (groups == null) {
            Snackbar.make(expandableListView, getString(R.string.error_get_data), Snackbar.LENGTH_SHORT).show();
        } else {
            expandableListAdapter.setGroups(groups);
            for (int i = 0; i < groups.size(); i++) {
                expandableListView.expandGroup(i, false);
            }
        }
    }

    @Override
    public void loadDone() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}