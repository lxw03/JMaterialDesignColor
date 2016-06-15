package com.dev.liji.materialdesigncolor.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.liji.materialdesigncolor.R;
import com.dev.liji.materialdesigncolor.model.ColorFirstPattle;
import com.dev.liji.materialdesigncolor.utils.JLogUtils;
import com.dev.liji.materialdesigncolor.widget.Headview;

import org.xutils.view.annotation.ViewInject;


public class SecondLayoutDetailInfo extends ActivityBase {

    @ViewInject(R.id.headview)
    Headview headview;

    @ViewInject(R.id.tv_name)
    TextView tvName;

    @ViewInject(R.id.tv_level)
    TextView tvLevel;

    @ViewInject(R.id.tv_web_value)
    TextView tvWebValue;

    @ViewInject(R.id.rlbg)
    RelativeLayout relativeLayoutBg;

    @ViewInject(R.id.rl_rgb_value)
    TextView rlRgbValue;

    private Integer pos = 0;
    private Integer positionValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        headview.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void initData() {
        pos = Integer.parseInt(this.getIntent().getStringExtra("pos"));
        positionValue = Integer.parseInt(this.getIntent().getStringExtra("positionValue"));
        JLogUtils.D("pos:" + pos);
        JLogUtils.D("positionValue:" + positionValue);

        Object[][] color = (Object[][]) ColorFirstPattle.objects[positionValue];

        headview.setBackgroundCustomeColor(Color.parseColor(((String) color[pos][1])));
        headview.setTitle("" + ColorFirstPattle.nameFirst[positionValue] + " Info");
        tvName.setText("" + ((String) ColorFirstPattle.nameFirst[positionValue]));
        tvLevel.setText("" + ((String) color[pos][0]));
        tvWebValue.setText("" + ((String) color[pos][1]));
        rlRgbValue.setText("" + (Color.parseColor((String) color[pos][1])));
        relativeLayoutBg.setBackgroundColor(Color.parseColor(((String) color[pos][1])));
        relativeLayoutBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondLayoutDetailInfo.this, "test", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getLayoutViewId() {
        return R.layout.activity_second_layout_detail_info;
    }
}
