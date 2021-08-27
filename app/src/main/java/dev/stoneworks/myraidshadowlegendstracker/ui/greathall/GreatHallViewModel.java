package dev.stoneworks.myraidshadowlegendstracker.ui.greathall;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GreatHallViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GreatHallViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}