package com.example.ngannguyen.camera720android.Interface;

public interface BrushFragmentLisenter {
    void onBrushSizeChangedListener(float size);
    void onBrushOpacityChangedListener(int opacity);
    void onBrushColorChangedListener(int color);
    void onBrushStateChangedListener(boolean isChecked);

}

