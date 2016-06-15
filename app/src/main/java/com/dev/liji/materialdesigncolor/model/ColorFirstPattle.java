package com.dev.liji.materialdesigncolor.model;

import android.graphics.Color;

/**
 * 颜色板
 * Created by liji on 16-6-14.
 */
public class ColorFirstPattle {

    //第一层颜色画板
    public static String[] nameFirst = {"Red", "Pink", "Purple", "Deep Purple",
            "Indigo", "Blue", "Light Blue", "Cyan",
            "Teal", "Green", "Light Green", "Lime",
            "Yellow", "Amber", "Orange", "Deep Orange",
            "Brown", "Gray", "Blue Gray"};
    public static String[] valueFirst = {"#F44336", "#E91E63", "#9C27B0", "#673AB7",
            "#3F51B5", "#2196F3", "#03A9F4", "#00BCD4",
            "#009688", "#4CAF50", "#8BC34A", "#CDDC39",
            "#FFEB3B", "#FFC107", "#FF9800", "#FF5722",
            "#795548", "#9E9E9E", "#607D8B"};

    public static Integer[] mdColorFirst = {Color.rgb(244, 67, 54), Color.rgb(233, 30, 99), Color.rgb(156, 39, 176), Color.rgb(103, 58, 183),
            Color.rgb(63, 81, 181), Color.rgb(33, 150, 243), Color.rgb(03, 169, 244), Color.rgb(00, 188, 212),
            Color.rgb(00, 150, 136), Color.rgb(76, 175, 80), Color.rgb(139, 195, 74), Color.rgb(205, 220, 57),
            Color.rgb(255, 255, 59), Color.rgb(255, 193, 07), Color.rgb(255, 152, 00), Color.rgb(255, 87, 34),
            Color.rgb(121, 85, 72), Color.rgb(158, 158, 158), Color.rgb(96, 125, 139)};


    //第二层颜色画板
    public static Object[][] colorRedValue = {
            {"50", "#FFEBEE", ""+Color.rgb(255, 235, 238)},
            {"100", "#FFCDD2", ""+Color.rgb(255, 205, 210)},
            {"200", "#EF9A9A", ""+Color.rgb(239, 154, 154)},
            {"300", "#E57373", ""+Color.rgb(229, 115, 115)},
            {"400", "#EF5350", ""+Color.rgb(239, 83, 80)},
            {"500", "#F44336", ""+Color.rgb(244, 67, 54)},
            {"600", "#E53935", ""+Color.rgb(229, 57, 53)},
            {"700", "#D32F2F", ""+Color.rgb(211, 47, 47)},
            {"800", "#C62828", ""+Color.rgb(198, 40, 40)},
            {"900", "#B71C1C", ""+Color.rgb(183, 28, 28)},
            {"A100", "#FF8A80", ""+Color.rgb(255, 138, 128)},
            {"A200", "#FF5252", ""+Color.rgb(255, 82, 82)},
            {"A400", "#FF1744", ""+Color.rgb(255, 23, 68)},
            {"A700", "#D50000", ""+Color.rgb(213, 00, 00)},
    };
    public static Object[][] colorPinkValue = {
            {"50", "#FCE4EC", ""+Color.rgb(252, 228, 236)},
            {"100", "#F8BBD0", ""+Color.rgb(248, 187, 208)},
            {"200", "#F48FB1", ""+Color.rgb(244, 143, 177)},
            {"300", "#F06292", ""+Color.rgb(240, 98, 146)},
            {"400", "#EC407A", ""+Color.rgb(236, 64, 122)},
            {"500", "#E91E63", ""+Color.rgb(233, 30, 99)},
            {"600", "#D81B60", ""+Color.rgb(216, 27, 96)},
            {"700", "#C2185B", ""+Color.rgb(194, 24, 91)},
            {"800", "#AD1457", ""+Color.rgb(173, 20, 87)},
            {"900", "#880E4F", ""+Color.rgb(136, 14, 79)},
            {"A100", "#FF80AB", ""+Color.rgb(255, 128, 171)},
            {"A200", "#FF4081", ""+Color.rgb(255, 64, 129)},
            {"A400", "#F50057", ""+Color.rgb(245, 00, 87)},
            {"A700", "#C51162", ""+Color.rgb(197, 17, 98)},
    };

    public static Object[] objects={colorRedValue,colorPinkValue};


}
