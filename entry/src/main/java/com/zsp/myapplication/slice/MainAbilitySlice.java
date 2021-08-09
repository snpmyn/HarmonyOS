package com.zsp.myapplication.slice;

import com.zsp.myapplication.ResourceTable;
import com.zsp.myapplication.value.Constant;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

/**
 * @desc: 主页薄片
 * @author: zsp
 * @date: 2021/8/4 4:49 PM
 */
public class MainAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    private Text mainAbilitySliceTv;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        method();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    /**
     * 方法
     */
    private void method() {
        mainAbilitySliceTv = (Text) findComponentById(ResourceTable.Id_mainAbilitySliceTv);
        Component mainAbilitySliceBtnJumpWithinAbilitySlice = findComponentById(ResourceTable.Id_mainAbilitySliceBtnJumpWithinAbilitySlice);
        mainAbilitySliceBtnJumpWithinAbilitySlice.setClickedListener(this);
        Component mainAbilitySliceBtnJumpBetweenPage = findComponentById(ResourceTable.Id_mainAbilitySliceBtnJumpBetweenPage);
        mainAbilitySliceBtnJumpBetweenPage.setClickedListener(this);
    }

    /**
     * 跳转到新页薄片
     */
    private void jumpToSecondAbilitySlice() {
        Intent intent = new Intent();
        Operation operation = new Intent.OperationBuilder().withDeviceId("")
                .withBundleName(getBundleName())
                .withAbilityName("com.zsp.myapplication.SecondAbility")
                .build();
        intent.setOperation(operation);
        intent.setParam(Constant.KEY, "我来自 " + this.getClass().getSimpleName());
        startAbilityForResult(intent, 1);
    }

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_mainAbilitySliceBtnJumpWithinAbilitySlice:
                Intent intent = new Intent();
                intent.setParam(Constant.KEY, "我来自 " + this.getClass().getSimpleName());
                presentForResult(new NewAbilitySlice(), intent, 0);
                break;
            case ResourceTable.Id_mainAbilitySliceBtnJumpBetweenPage:
                jumpToSecondAbilitySlice();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onAbilityResult(int requestCode, int resultCode, Intent resultData) {
        if ((resultCode != 0) || (null == resultData)) {
            return;
        }
        mainAbilitySliceTv.setText(resultData.getStringParam(Constant.KEY));
    }

    @Override
    protected void onResult(int requestCode, Intent resultIntent) {
        if ((requestCode != 0) || (null == resultIntent)) {
            return;
        }
        mainAbilitySliceTv.setText(resultIntent.getStringParam(Constant.KEY));
    }
}
