package dev.stoneworks.myraidshadowlegendstracker.ui.equipment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EquipmentViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EquipmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}