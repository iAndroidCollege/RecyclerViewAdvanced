package college.edu.tomer.recyclerviewadvanced;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tomer. Licence GPL 3.0.
 */
public class MRecyclerAdapter extends RecyclerView.Adapter<MRecyclerAdapter.MViewHolder> implements View.OnClickListener {

    /*
        Private members:
        */
    private ArrayList<String> data;
    private final RecyclerView mRecyclerView;

    //Constructor
    public MRecyclerAdapter(ArrayList<String> data, RecyclerView mRecyclerView) {
        this.data = data;
        this.mRecyclerView = mRecyclerView;
    }


    //Update the itemView from the viewHolder to display the data at position
    @Override
    public void onBindViewHolder(MViewHolder holder, int position) {
        holder.tvData.setText(data.get(position));

        View itemView = holder.itemView;



/*        holder.itemView.setScaleX(0);
        holder.itemView.setScaleY(0);*/
        //Prep Animation
        ViewCompat.setScaleX(itemView, 0);
        ViewCompat.setScaleY(itemView, 0);

        ViewCompat.animate(itemView).scaleX(1).scaleY(1);
        //ViewCompat.animate(itemView).scaleY(1);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    //Inflate The Xml into a view and init a viewHolder for findViewByID
    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d("College", "onCreateViewHolder");
        Context ctx = parent.getContext();
        View itemView = LayoutInflater.from(ctx).inflate(R.layout.rv_list_item, parent, false);

        MViewHolder vHolder = new MViewHolder(itemView);
        vHolder.btnRemove.setOnClickListener(this);
        return vHolder;
    }

    public void addNew(String item) {
        data.add(item);
        notifyItemInserted(data.size());
    }

    @Override
    public void onClick(View v) {
        //Remove Item clicked
       int position =  mRecyclerView.getChildAdapterPosition((View)v.getParent());
       if (position!=-1){
           data.remove(position);
           notifyItemRemoved(position);
       }
    }

    /**
     *Find All Views by ID Once and for good
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
