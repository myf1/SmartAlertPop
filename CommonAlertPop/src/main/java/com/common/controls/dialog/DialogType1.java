package com.common.controls.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 类型1 Dialog
 * 仅有标题，无内容，两个按钮
 */

public class DialogType1 extends DialogBase {
    private TextView mCancelTv;
    private TextView mOkTv;
    private View mMiddleDivider;

    public DialogType1(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type1, null);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
        mMiddleDivider = rootView.findViewById(R.id.common_dialog_btn_middle_divider);
        createDialog(rootView);
    }

    @Override
    public void setCancelBtnText(int textId) {
        mCancelTv.setText(textId);
    }

    @Override
    public void setCancelBtnText(CharSequence text) {
        mCancelTv.setText(text);
    }

    @Override
    public void setOkBtnText(int textId) {
        mOkTv.setText(textId);
    }

    @Override
    public void setOkBtnStyleType(int okBtnStyleType) {
        mOkTv.setBackgroundResource(DialogUtil.getOkBtnBgResId(okBtnStyleType));
        mOkTv.setTextColor(DialogUtil.getOkBtnTextColorValue(okBtnStyleType, mOkTv.getContext()));
        mMiddleDivider.setVisibility(DialogUtil.isBtnMiddleDividerVisible(okBtnStyleType) ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setOkBtnText(CharSequence text) {
        mOkTv.setText(text);
    }

    @Override
    public void bindAllListeners() {
        mCancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType1.this.onCancelClick(v);
            }
        });
        mOkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType1.this.onOkClick(v);
            }
        });
    }

}
