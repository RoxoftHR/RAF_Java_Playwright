package org.raf3k.testproject.extendedtypes.ui;

import org.openqa.selenium.By;
import org.raf3k.guittesting.webtesting.basetypes.WebControlBase;
import org.raf3k.guittesting.webtesting.types.WbLabel;

public class WbLabelEx extends WbLabel {
    public WbLabelEx(By SearchBy, String Alias) {
        super(SearchBy, Alias);
    }

    public WbLabelEx(By SearchBy, WebControlBase Parent, String Alias) {
        super(SearchBy, Parent, Alias);
    }
}
