package com.common.controls.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 类型203 Dialog
 * 有标题，标题有背景，有自定义布局内容，一个确定按钮
 */

public class DialogType203 extends DialogBase {
    private View mTitleRoot;
    private FrameLayout mContentContainer;
    private TextView mOkTv;

    public DialogType203(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type203, null);
        mTitleRoot = rootView.findViewById(R.id.common_dialog_title_root);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mContentContainer = (FrameLayout) rootView.findViewById(R.id.common_dialog_content_container);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
        createDialog(rootView);
    }

    @Override
    public void setTitleBgType(int titleBgType) {
        mTitleRoot.setBackgroundResource(DialogUtil.getTitleBgResId(titleBgType));
    }

    @Override
    public void setContentView(int contentLayoutId) {
        LayoutInflater.from(mContext).inflate(contentLayoutId, mContentContainer, true);
    }

    @Override
    public void setContentView(View contentView) {
        mContentContainer.addView(contentView);
    }

    @Override
    public void setContentView(View contentView, ViewGroup.LayoutParams params) {
        mContentContainer.addView(contentView, params);
    }

    @Override
    public void setOkBtnText(int textId) {
        mOkTv.setText(textId);
    }

    @Override
    public void setOkBtnText(CharSequence text) {
        mOkTv.setText(text);
    }

    @Override
    public void setOkBtnStyleType(int okBtnStyleType) {
        mOkTv.setBackgroundResource(DialogUtil.getOkBtnBgResId(okBtnStyleType));
        mOkTv.setTextColor(DialogUtil.getOkBtnTextColorValue(okBtnStyleType, mOkTv.getContext()));
    }

    @Override
    public void bindAllListeners() {
        mOkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType203.this.onOkClick(v);
            }
        });
    }

}
