package com.zsp.myapplication.slice;

import com.zsp.myapplication.ResourceTable;
import com.zsp.myapplication.value.Constant;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

/**
 * Created on 2021/8/5
 *
 * @author zsp
 * @desc 新页薄片
 */
public class NewAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_new);
        method(intent);
    }

    @Override
    public void onActive() {
        super.onActive();
        Intent intent = new Intent();
        intent.setParam(Constant.KEY, "我从 NewAbilitySlice 跳回来咯");
        setResult(intent);
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
    private void method(@org.jetbrains.annotations.NotNull Intent intent) {
        Text newAbilitySliceTv = (Text) findComponentById(ResourceTable.Id_newAbilitySliceTv);
        newAbilitySliceTv.setText(intent.getStringParam(Constant.KEY));
        Component newAbilitySliceBtn = findComponentById(ResourceTable.Id_newAbilitySliceBtn);
        newAbilitySliceBtn.setClickedListener(component -> terminate());
    }
}
