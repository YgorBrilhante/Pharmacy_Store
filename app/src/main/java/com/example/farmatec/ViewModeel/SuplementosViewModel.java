package com.example.farmatec.ViewModeel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.farmatec.API.Repository;
import com.example.farmatec.ui.main.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuplementosViewModel extends ViewModel {

    public enum State {
        DOING, DONE, ERROR;
    }

    private final MutableLiveData<List<Product>> suplementos = new MutableLiveData<>();
    private final MutableLiveData<State> state = new MutableLiveData<>();

    public SuplementosViewModel() {
        this.findSuplementos();
    }

    public void findSuplementos() {
        state.setValue(State.DOING);
        Repository.getInstance().getRemoteApi().getProduct().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    suplementos.setValue(response.body());
                    state.setValue(State.DONE);
                } else {
                    state.setValue(State.ERROR);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Product>> call, @NonNull Throwable error) {
                error.printStackTrace();
                state.setValue(State.ERROR);
            }
        });
    }

    public LiveData<List<Product>> getProduct() {
        return this.suplementos;
    }

    public LiveData<State> getState() {
        return this.state;
    }
}
