package dev.stoneworks.myraidshadowlegendstracker.ui.greathall;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import dev.stoneworks.myraidshadowlegendstracker.databinding.FragmentGreathallBinding;

public class GreatHallFragment extends Fragment {

    private GreatHallViewModel greatHallViewModel;
    private FragmentGreathallBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        greatHallViewModel =
                new ViewModelProvider(this).get(GreatHallViewModel.class);

        binding = FragmentGreathallBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGreathall;
        greatHallViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}