package projectite.m2.fe.rupp.edu.iteonlineshop.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import projectite.m2.fe.rupp.edu.iteonlineshop.api.model.Product;
import projectite.m2.fe.rupp.edu.iteonlineshop.databinding.ViewHolderProductBinding;

public class ProductAdapter extends ListAdapter<Product, ProductAdapter.ProductViewHolder> {

    // Method Adapter
    public ProductAdapter() {

        super(new DiffUtil.ItemCallback<Product>() {
            @Override
            public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
                return oldItem.getId().equals(newItem.getId());
            }
        });
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolderProductBinding binding= ViewHolderProductBinding.inflate(layoutInflater, parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

        Product item = getItem(position);
        holder.bind(item);
    }



    // Ti 1 by create
    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        private final ViewHolderProductBinding itemBinding;

        public ProductViewHolder(ViewHolderProductBinding itemBinding){
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(Product product) {
            itemBinding.txtName.setText(product.getName());
            itemBinding.texNum.setText("$" + product.getPrice() + ".00");
            Picasso.get().load(product.getImageUrl()).into(itemBinding.imgUrl);

        }
    }
}
