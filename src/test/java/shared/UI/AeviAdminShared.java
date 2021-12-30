package shared.UI;

import base.UI.BaseUtil;
import map.UI.AeviAdminMap;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class AeviAdminShared extends BaseUtil {

    public static void Wait(int iTime)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(iTime));
    }

    public static void ThreadWait(int iTime)
    {
        try {
            Thread.sleep(iTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement FindButtonByName(String sButtonName) {
        WebElement button = null;
        String sPage = driver.getTitle();

        switch (sPage) {
            case "AEVI Pay Admin | Login":
                switch (sButtonName) {
                    case "Save Changes":
                        ThreadWait(1000);
                        button = AeviAdminMap.LoginPage.btnSaveChanges;
                        break;
                }
                break;
            case "AEVI Pay Admin | Organization Units":
                switch (sButtonName) {
                    case "New Record":
                        button = AeviAdminMap.OrganizationUnits.btnNewRecord;
                        break;
                    case "Add Site":
                        button = AeviAdminMap.OrganizationUnits.btnAddSite;
                        break;
                }
                break;
            case "AEVI Pay Admin | Site":
                switch (sButtonName) {
                    case "Site ID Reload":
                        button = AeviAdminMap.OrganizationUnitsSite.btnSiteIdReload;
                        break;
                }
                break;
            case "AEVI Pay Admin | Terminals":
                switch (sButtonName) {
                    case "New Record":
                        button = AeviAdminMap.Terminals.btnNewRecord;
                        break;
                }
                break;
            case "AEVI Pay Admin | Terminal":
                switch (sButtonName) {
                    case "Terminal ID Reload":
                        button = AeviAdminMap.TerminalsAdd.btnSiteIdReload;
                        break;
                }
                break;
            case "AEVI Pay Admin | Data Groups":
                switch (sButtonName) {
                    case "New Record":
                        button = AeviAdminMap.DataGroups.btnNewRecord;
                        break;
                    case "Search":
                        button = AeviAdminMap.DataGroups.btnSearch;
                        break;
                    case "Delete":
                        button = AeviAdminMap.DataGroups.btnDelete;
                        break;
                }
                break;
            case "AEVI Pay Admin | Data Group":
                switch (sButtonName) {
                    case "OK":
                        button = AeviAdminMap.DataGroupsAdd.btnOK;
                        break;
                }
                break;
            case "AEVI Pay Admin | Contracts":
                switch (sButtonName) {
                    case "New Record":
                        button = AeviAdminMap.Contracts.btnNewRecord;
                        break;
                    case "Add Physical Contract":
                        button = AeviAdminMap.Contracts.btnAddPhysicalContract;
                        break;
                }
                break;
        }
        return button;
    }

    public static WebElement FindTextboxByName(String sTextboxName) {
        WebElement textbox = null;
        String sPage = driver.getTitle();

        switch (sPage) {
            case "AEVI Pay Admin | Data Groups":
                switch (sTextboxName) {
                    case "Name":
                        textbox = AeviAdminMap.DataGroups.txtName;
                        break;
                }
                break;
            case "AEVI Pay Admin | Data Group":
                switch (sTextboxName) {
                    case "Name":
                        textbox = AeviAdminMap.DataGroupsAdd.txtName;
                        break;
                }
                break;
            case "AEVI Pay Admin | Site":
                switch (sTextboxName) {
                    case "Site ID":
                        ThreadWait(1000);
                        textbox = AeviAdminMap.OrganizationUnitsSite.txtSiteId;
                        break;
                    case "Parent Unit":
                        textbox = AeviAdminMap.OrganizationUnitsSiteDropdownSite.txtParentUnitSearch;
                        break;
                }
                break;
            case "AEVI Pay Admin | Terminal":
                switch (sTextboxName) {
                    case "Terminal ID":
                        textbox = AeviAdminMap.TerminalsAdd.txtTerminalId;
                        break;
                    case "Organization Unit":
                        textbox = AeviAdminMap.OrganizationUnitsSiteDropdownSite.txtParentUnitSearch;
                        break;
                }
                break;
        }

        return textbox;
    }

    public static WebElement FindCheckboxByName(String sCheckboxName) {
        WebElement checkbox = null;
        String sPage = driver.getTitle();

        switch (sPage) {
            case "AEVI Pay Admin | Data Group":
                switch (sCheckboxName) {
                    case "Status":
                        checkbox = AeviAdminMap.DataGroupsAdd.chkStatus;
                        break;
                    case "Check Site ID/Terminal ID":
                        checkbox = AeviAdminMap.DataGroupsAdd.chkSiteTerminalId;
                        break;
                }
                break;
        }

        return checkbox;
    }

    public static WebElement FindTabByName(String sCheckboxName) {
        WebElement checkbox = null;
        String sPage = driver.getTitle();

        switch (sPage) {
            case "AEVI Pay Admin | Data Group":
                switch (sCheckboxName) {
                    case "Parameters":
                        checkbox = AeviAdminMap.DataGroupsAdd.tabParameters;
                        break;
                }
                break;
            case "AEVI Pay Admin | Contract":
                switch (sCheckboxName) {
                    case "Parameters":
                        checkbox = AeviAdminMap.ContractsAdd.tabParameters;
                        break;
                }
                break;
        }

        return checkbox;
    }

    public static void VerifyTableColumnExists(List<WebElement> headers, String columnName)
    {
        for(WebElement header : headers)
        {
            if(header.getText().equals(columnName))
            {
                Assert.assertTrue(true);
                return;
            }
        }

        Assert.fail("Table column doesn't exist: " + columnName);
    }


    public static String GetCellValueByColumnNameAndRowIndex(List<WebElement> headers, List<WebElement> row, String columnName)
    {
        VerifyTableColumnExists(headers,columnName);

        Integer columnNumber = 0;
        for(int i = 1; i<=headers.size(); i++)
        {
            if(headers.get(i).getText().equals(columnName))
            {
                columnNumber = i;
                break;
            }
        }

        return row.get(columnNumber).getText();
    }
}
