package com.arkea.client.android.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.arkea.client.android.R;
import com.arkea.thrift.data.message.Message;

public class MessageAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<Message> messages;

	 
	public MessageAdapter(Context context, List<Message> messageList) {
        // Cache the LayoutInflate to avoid asking for a new one each time.
        mInflater = LayoutInflater.from(context);
        messages = messageList;
	}

	@Override
	public int getCount() {
		return messages.size();
	}



	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public Object getItem(int position)  {
		return position;
	}

	/**
     * Make a view to hold each row.
     *
     * @see android.widget.ListAdapter#getView(int, android.view.View,
     *      android.view.ViewGroup)
     */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {	
		// A ViewHolder keeps references to children views to avoid unneccessary calls
        // to findViewById() on each row.
        ViewHolder holder;

        // When convertView is not null, we can reuse it directly, there is no need
        // to reinflate it. We only inflate a new View when the convertView supplied
        // by ListView is null.
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.message, null);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder();
            holder.user = (TextView) convertView.findViewById(R.id.message_user);
            holder.message = (TextView) convertView.findViewById(R.id.message_message);

            convertView.setTag(holder);
        } else {
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind the data efficiently with the holder.
        holder.user.setText(messages.get(position).getUtilisateur().getPseudo());
        holder.message.setText(messages.get(position).getContenu());

        return convertView;
    }

    static class ViewHolder {
        TextView user;
        TextView message;
    }
}
