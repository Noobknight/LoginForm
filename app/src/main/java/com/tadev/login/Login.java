package com.tadev.login;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by PC on 11/05/2016.
 */
public class Login extends LinearLayout implements View.OnClickListener {
    private final String TAG = "Login";

    private Settings settings = new Settings();
    private LoginCallBack mCallBack;

    private FrameLayout loginContainer;

    private LinearLayout lrlIdeaLogin, lrlSocialContainer;

    private EditText edtFirstField, edtSecondsField;

    private View viewTransparent;

    private TextView txtForgetPwd;

    private ImageView iconCompany;

    private AppCompatButton btnLogin;

    private View btnLoginFb, btnLoginGplus;

    private String regexUser, regexPwd;

    private boolean canLogin;

    private TextInputLayout tilFirstField, tilSecondsField;


    private Validation validation = new Validation();

    private Message message = new Message();


    public Login(Context context) {
        super(context);

    }

    public Login(Context context, AttributeSet attrs) {
        super(context, attrs);
        settings.handleAttributes(context, attrs);
    }

    public Login(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        settings.handleAttributes(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Login(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        settings.handleAttributes(context, attrs);
    }

    @Override
    protected void onDetachedFromWindow() {
        mCallBack = null;
        super.onDetachedFromWindow();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addView(LayoutInflater.from(getContext()).inflate(R.layout.login_layout, this, false));
        //initialization view
        loginContainer = (FrameLayout) findViewById(R.id.login_container);
        iconCompany = (ImageView) findViewById(R.id.icon);
        edtFirstField = (EditText) findViewById(R.id.edtFirstField);
        edtSecondsField = (EditText) findViewById(R.id.edtSecondsField);
        viewTransparent = (View) findViewById(R.id.viewTransparent);
        lrlIdeaLogin = (LinearLayout) findViewById(R.id.lrlIdeaLogin);
        lrlSocialContainer = (LinearLayout) findViewById(R.id.lrlSocialContainer);
        tilFirstField = (TextInputLayout) findViewById(R.id.til_firstField);
        tilSecondsField = (TextInputLayout) findViewById(R.id.til_secondsField);
        txtForgetPwd = (TextView) findViewById(R.id.txtForgetPwd);
        btnLogin = (AppCompatButton) findViewById(R.id.btnLogin);
        btnLoginFb = (View) findViewById(R.id.btnLoginFb);
        btnLoginGplus = (View) findViewById(R.id.btnLoginGPlus);
        //enable connect to socical network;
        if (!settings.enableSocial) {
            lrlSocialContainer.setVisibility(GONE);
            lrlIdeaLogin.setVisibility(GONE);
        }
        //set hint for edittext
//        edtFirstField.setHint(settings.firstFieldName);
//        edtSecondsField.setHint(settings.secondsFieldName);
        tilFirstField.setHint(settings.firstFieldName);
        tilSecondsField.setHint(settings.secondsFieldName);
        //set icon for form(Company)
        if (settings.icon == -1) {
            iconCompany.setImageResource(R.drawable.ic_company);
        } else {
            iconCompany.setImageResource(settings.icon);
        }
        //check color background form
        if (settings.isBackgroundColor()) {
            loginContainer.setBackgroundColor(settings.colorBackground);
        } else {
            loginContainer.setBackgroundResource(settings.background);
        }
        //set color transparent form
        viewTransparent.setBackgroundColor(settings.colorAlpha);
        //set Color button login
        GradientDrawable bgShape = (GradientDrawable) btnLogin.getBackground();
        bgShape.setColor(settings.colorBackgroundButton);
        //set color text button
        btnLogin.setTextColor(settings.colorTextButton);
        //set event for views
        setEventViews();


    }

    private void setEventViews() {
        btnLogin.setOnClickListener(this);
        btnLoginFb.setOnClickListener(this);
        btnLoginGplus.setOnClickListener(this);
        txtForgetPwd.setOnClickListener(this);
        edtFirstField.addTextChangedListener(new InputValidator(edtFirstField));
        edtSecondsField.addTextChangedListener(new InputValidator(edtSecondsField));
    }


    public Message getMessage() {
        return message;
    }

    public void setIcon(int iconResId) {
        iconCompany.setBackgroundResource(iconResId);
    }

    public void setNameFirstField(String firstFieldName) {
        edtFirstField.setHint(firstFieldName);
    }

    public void setNameSecondsField(String secondsFieldName) {
        edtSecondsField.setHint(secondsFieldName);
    }

    public void setRegexUser(String regexUser) {
        this.regexUser = regexUser;
    }


    public void setRegexPwd(String regexPwd) {
        this.regexPwd = regexPwd;
    }


    public void setLoginListener(LoginCallBack callBack) {
        this.mCallBack = callBack;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin) {
            canLogin = regexPwd == null ? validation.isUser(edtFirstField.getText().toString(), regexUser) :
                    validation.isUser(edtFirstField.getText().toString(), regexUser) &&
                            validation.isPassword(edtSecondsField.getText().toString(), regexPwd);
            if (!edtFirstField.getText().toString().isEmpty()
                    && !edtSecondsField.getText().toString().isEmpty()
                    && canLogin) {
                mCallBack.onLoginClick(view);
                return;
            }
            if (TextUtils.isEmpty(message.getMsgEmpty())) {
                if (edtFirstField.getText().toString().trim().isEmpty()) {
                    edtFirstField.setError(getResources().getString(R.string.txtEmpty));
                    edtFirstField.requestFocus();
                } else if (edtSecondsField.getText().toString().trim().isEmpty()) {
                    edtSecondsField.setError(getResources().getString(R.string.txtEmpty));
                    edtSecondsField.requestFocus();
                }
            }
        } else if (view.getId() == R.id.btnLoginFb) {
            mCallBack.onLoginClick(view);
        } else if (view.getId() == R.id.btnLoginGPlus) {
            mCallBack.onLoginClick(view);
        } else if (view.getId() == R.id.txtForgetPwd) {
            mCallBack.onLoginClick(view);
        }
    }


    private class InputValidator implements TextWatcher {
        View view;

        public InputValidator(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (view.getId() == R.id.edtFirstField) {
                String userName = editable.toString();
                if (regexUser != null) {
                    if (!validation.isUser(userName, regexUser)) {
                        edtFirstField.setError(message.getMsgErrorUser());
                    } else {
                        edtFirstField.setError(null);
                    }
                }
            } else if (view.getId() == R.id.edtSecondsField) {
                String pwd = editable.toString();
                if (regexPwd != null) {
                    if (!validation.isPassword(pwd, regexPwd)) {
                        edtSecondsField.setError(message.getMsgErrorPwd());
                    } else {
                        edtSecondsField.setError(null);
                    }
                }
            }
        }
    }


    public interface LoginCallBack {
        void onLoginClick(View view);
    }
}
