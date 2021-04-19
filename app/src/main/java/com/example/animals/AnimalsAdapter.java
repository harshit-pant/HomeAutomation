package com.example.animals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.AnimalRowHolder> {

        ArrayList<Animal> animalData;
        Context context;
        MyClickInterface myClickInterface;

    public AnimalsAdapter (ArrayList<Animal> animalData, Context context, MyClickInterface myClickInterface)
    {
        this.context = context;
        this.animalData = animalData;
        this.myClickInterface = myClickInterface;
    }


    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.animals_row, parent, false);
        return new AnimalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {

        holder.txtAnimal.setText(animalData.get(position).getName());
        holder.imgAnimal.setImageResource(animalData.get(position).getImage());

    }

    @Override
    public int getItemCount() {


        return animalData.size();
    }

    class AnimalRowHolder extends RecyclerView.ViewHolder {

        ImageView imgAnimal;
        TextView txtAnimal;
        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);

            imgAnimal = itemView.findViewById(R.id.image_dog);
            txtAnimal = itemView.findViewById(R.id.text_dog);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myClickInterface.onItemClickItem(getAdapterPosition());
                }
            });
        }
    }

    interface MyClickInterface {

            void onItemClickItem(int PositionOfTheAnimal);
    }

}
