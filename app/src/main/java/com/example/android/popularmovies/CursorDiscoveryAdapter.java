package com.example.android.popularmovies;

import android.content.Context;
import android.database.Cursor;

import com.example.android.popularmovies.data.Movie;

/**
 * Created by john on 09/04/18.
 */

public class CursorDiscoveryAdapter extends DiscoveryAdapter {

    // Class variable for the Cursor that holds task data
    private Cursor mCursor;

    /**
     * Initializes the adapter with a {@link Context}
     *
     * @param context       typically the container activity
     */
    public CursorDiscoveryAdapter(Context context) {
        super(context);
    }

    /**
     * Returns the item at that position.
     */
    @Override
    public Movie getItem(int position) {
        if (mCursor.moveToPosition(position)) {
            return new Movie(mCursor);
        }
        return null;
    }

    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        }
        return mCursor.getCount();
    }

    /**
     * When data changes and a re-query occurs, this function swaps the old Cursor
     * with a newly updated Cursor (Cursor c) that is passed in.
     */
    public Cursor swapCursor(Cursor c) {
        // check if this cursor is the same as the previous cursor (mCursor)
        if (mCursor == c) {
            return null; // bc nothing has changed
        }
        Cursor temp = mCursor;
        this.mCursor = c; // new cursor value assigned

        //check if this is a valid cursor, then update the cursor
        if (c != null) {
            this.notifyDataSetChanged();
        }
        return temp;
    }

    /**
     * Adds a movie to the adapter and notifies any registered observers that the item reflected at
     * position has been newly inserted. The item previously at position is now at position
     * position + 1.
     *
     * @param movie
     */
    @Override
    public void add(Movie movie) {
        // TODO
    }

    @Override
    public void remove(Movie movie) {
        // TODO
    }
}
