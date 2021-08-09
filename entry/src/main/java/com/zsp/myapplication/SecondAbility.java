package com.zsp.myapplication;

import com.zsp.myapplication.slice.SecondAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

/**
 * @desc: 第二页
 * @author: zsp
 * @date: 2021/8/5 2:12 PM
 */
public class SecondAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(SecondAbilitySlice.class.getName());
    }
}
