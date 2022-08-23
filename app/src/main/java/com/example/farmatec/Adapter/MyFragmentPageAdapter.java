package com.example.farmatec.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmatec.FragmentEstetica;
import com.example.farmatec.FragmentMedicamentos;
import com.example.farmatec.FragmentSuplementos;
import com.example.farmatec.databinding.ProductItemBinding;
import com.example.farmatec.ui.main.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyFragmentPageAdapter extends RecyclerView.Adapter<MyFragmentPageAdapter.ViewHolder> {

    public final Object CarrinhoListener;
    public String[] mTabTitles;
    public final List<Product> products;
    public MyFragmentPageAdapter.CarrinhoListener carrinhoListener;

    public MyFragmentPageAdapter(FragmentManager fm, String[] mTabTitles, List<Product> products) {
        super();
        this.mTabTitles = mTabTitles;
        this.products = products;
        this.CarrinhoListener = carrinhoListener;


    }

    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FragmentSuplementos();
            case 1:
                return new FragmentMedicamentos();
            case 2:
                return new FragmentEstetica();
            default:
                return null;
        }
    }


    public int getCount() {
        return this.mTabTitles.length;
    }


    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ProductItemBinding binding = ProductItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyFragmentPageAdapter.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Product products = this.products.get(position);
        holder.binding.txtTitleProduct.setText(products.getTitle());
        holder.binding.txtPriceProduct.setText(products.getPrice());
        Picasso.get().load(products.getImage()).into(holder.binding.imgProduct);
        holder.binding.btnCarrinho.setOnClickListener( view ->{
            products.carrinho = !products.carrinho;
           this.carrinhoListener.onCarrinho(products);
            notifyItemChanged(position);
                });

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ProductItemBinding binding;

        public ViewHolder(ProductItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface CarrinhoListener {
        void onCarrinho(Product products);
    }
}
