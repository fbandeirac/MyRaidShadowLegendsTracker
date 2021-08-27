package dev.stoneworks.myraidshadowlegendstracker.ui.champion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChampionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ChampionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is champions fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}