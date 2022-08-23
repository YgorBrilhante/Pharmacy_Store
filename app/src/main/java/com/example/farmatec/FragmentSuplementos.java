package com.example.farmatec;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.farmatec.ViewModeel.SuplementosViewModel;
import com.example.farmatec.databinding.FragmentSuplementosBinding;

public class FragmentSuplementos extends Fragment {

    private FragmentSuplementosBinding binding;
    private SuplementosViewModel suplementosViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        suplementosViewModel =
                new ViewModelProvider(this).get(SuplementosViewModel.class);

        binding = FragmentSuplementosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.rvSuplementos.setLayoutManager(new LinearLayoutManager(getContext()));


        observeStates();

        binding.srlSuplementos.setOnRefreshListener(suplementosViewModel::findSuplementos);

        return root;
    }


    private void observeStates() {
        suplementosViewModel.getState().observe(getViewLifecycleOwner(), state -> {
            switch (state) {
                case DOING:
                    binding.srlSuplementos.setRefreshing(true);
                case DONE:
                    binding.srlSuplementos.setRefreshing(false);
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

