package vtc.edu.hk.idea;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import vtc.edu.hk.idea.data.IdeaContent;
import vtc.edu.hk.idea.data.IdeaItem;

/**
 * A fragment representing a single Idea detail screen.
 * This fragment is either contained in a {@link IdeaListActivity}
 * in two-pane mode (on tablets) or a {@link IdeaDetailActivity}
 * on handsets.
 */
public class IdeaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "id";

    /**
     * The dummy content this fragment is presenting.
     */
    private IdeaItem mItem;
    private int ideaId;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public IdeaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            //TODO: Get IdeaItem from API.
            ideaId = getArguments().getInt(ARG_ITEM_ID);
            mItem = IdeaContent.ITEM_MAP.get(ideaId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_idea_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            //TODO: Print out the useful content!
            ((TextView) rootView.findViewById(R.id.idea_detail)).setText(mItem.getName() + '\n' + mItem.getUrl());
        }

        return rootView;
    }
}
