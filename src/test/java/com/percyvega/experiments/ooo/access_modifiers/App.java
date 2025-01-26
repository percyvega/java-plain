package com.percyvega.experiments.ooo.access_modifiers;

import com.percyvega.experiments.ooo.access_modifiers.same_package.MyChild;
import com.percyvega.experiments.ooo.access_modifiers.same_package.MyFather;
import com.percyvega.experiments.ooo.access_modifiers.same_package.MyGrandchild;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class App {

    private final MyChild myChild = new MyChild("593-10-1000", "954-700-7000", "Vega", "Percy");
    private final MyGrandchild myGrandchild = new MyGrandchild("593-10-1000", "954-700-7000", "Vega", "Percy");

    @Test
    public void child_calling_fatherMethod_whichUses_privateFields() {
        myChild.printFatherValuesWithoutGetters();
    }

    @Test
    public void grandchild_calling_grandfatherMethod_whichUses_grandchildMethod() {
        myGrandchild.printFatherValuesWithoutGetters();
        myGrandchild.printFatherValuesUsingGetters();
    }

    @Test
    public void casting_child_to_father_to_child() {
        MyFather myFather1 = myChild;
        myFather1.printFatherValuesUsingGetters();

        MyChild myChild1 = (MyChild) myFather1;
        myChild1.printInheritedValues();
    }

}
