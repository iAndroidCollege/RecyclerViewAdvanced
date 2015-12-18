package college.edu.tomer.recyclerviewadvanced;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tomer. Licence GPL 3.0.
 */
public class MRecyclerAdapter extends RecyclerView.Adapter<MRecyclerAdapter.MViewHolder>{

    /*
    Private members:
    */
    private ArrayList<String> data;


    //Constructor
    public MRecyclerAdapter(ArrayList<String> data) {
        this.data = data;
    }


    //Update the itemView from the viewHolder to display the data at position
    @Override
    public void onBindViewHolder(MViewHolder holder, int position) {
        holder.tvData.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    //Inflate The Xml into a view and init a viewHolder for findViewByID
    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context ctx = parent.getContext();
        View itemView = LayoutInflater.from(ctx).inflate(R.layout.rv_list_item, parent, false);
        return new MViewHolder(itemView);
    }
    /**
     *Find All View by ID Once and for good
    **/
    public static class MViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        TextView tvData;
        Button btnRemove;

        //* More Views here...
        public MViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvData = (TextView) itemView.findViewById(R.id.tvData);
            btnRemove = (Button) itemView.findViewById(R.id.btnRemove);
        }
    }
}
