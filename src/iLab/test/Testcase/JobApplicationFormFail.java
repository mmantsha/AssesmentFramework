package iLab.test.Testcase;

import iLab.framework.config.Settings;
import iLab.framework.utilities.MyRetryUtil;
import iLab.framework.utilities.ScreenRecorderUtil;
import iLab.test.InitializeTests;
import iLab.test.pages.CareerOpportunitiesPage;
import iLab.test.pages.CareerOpportunitiesSouthAfricaPage;
import iLab.test.pages.FillQAFormPage;
import iLab.test.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class JobApplicationFormFail extends InitializeTests {


    @Test(retryAnalyzer = MyRetryUtil.class)

    public void JobApplicationFormFail() throws Exception {

        // ************************************** //
        //              Home Page               //
        // ************************************* //

        ScreenRecorderUtil.startRecord("JobApplicationForm");

        HomePage hp = new HomePage();
        hp.clickAcceptAll();
        hp.clickCareerLnk();
   // ************************************** //
        //         Career Opportunities          //
        // ************************************* //

        CareerOpportunitiesPage career = new CareerOpportunitiesPage();
        career.clickCareerLnk();

        // ************************************** //
        //             South Africa              //
        // ************************************* //

        CareerOpportunitiesSouthAfricaPage careerSA= new CareerOpportunitiesSouthAfricaPage();
        careerSA.clickQaJob();

        // ************************************** //
        //             Form                      //
        // ************************************* //

        FillQAFormPage form = new FillQAFormPage();
        form.setFirstName(Settings.FirstName);
        form.setLastName(Settings.LastName);
        form.setEmail("automationAssessment@iLABQuality.com");
        form.setPhoneNumber();
        form.clickSubmit();
        String text = form.actualText();
        String error = "Please complete this required field. This should fail";
        Assert.assertEquals(text,error);

        ScreenRecorderUtil.stopRecord();

    }

}
