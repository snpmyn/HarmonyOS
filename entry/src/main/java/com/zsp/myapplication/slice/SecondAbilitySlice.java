package com.zsp.myapplication.slice;

import com.zsp.myapplication.ResourceTable;
import com.zsp.myapplication.value.Constant;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

/**
 * @desc: 第二页薄片
 * @author: zsp
 * @date: 2021/8/5 2:12 PM
 */
public class SecondAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_second);
        method(intent);
    }

    @Override
    public void onActive() {
        super.onActive();
        Intent intent = new Intent();
        intent.setParam(Constant.KEY, "我从 SecondAbilitySlice 跳回来咯");
        getAbility().setResult(0, intent);
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    /**
     * 方法
     *
     * @param intent 意图
     */
    private void method(Intent intent) {
        Text secondAbilitySliceTv = (Text) findComponentById(ResourceTable.Graphic_background_ability_second_text);
        secondAbilitySliceTv.setText(intent.getStringParam(Constant.KEY));
        Component secondAbilitySliceBtn = findComponentById(ResourceTable.Id_secondAbilitySliceBtn);
        secondAbilitySliceBtn.setClickedListener(component -> terminate());
    }
}
