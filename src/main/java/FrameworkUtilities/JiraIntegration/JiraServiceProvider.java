package FrameworkUtilities.JiraIntegration;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {

    private JiraClient jira;
    private String project;

    public JiraServiceProvider(String jiraUrl, String username, String password, String project) {
        // create basic authentication object
        BasicCredentials creds = new BasicCredentials(username, password);
        // initialize the jira client with the url and the credentials
        jira = new JiraClient(jiraUrl, creds);
        this.project = project;
    }

    public void createJiraIssue(String issueType, String summary, String description, String reporterName) {
        /* Create a new issue. */
        try {
            FluentCreate newIssueFluentCreate = jira.createIssue(project, issueType);
            newIssueFluentCreate.field(Field.SUMMARY, summary);
            newIssueFluentCreate.field(Field.DESCRIPTION, description);
            Issue newIssue = newIssueFluentCreate.execute();
            System.out.println("New issue created. Jira ID : " + newIssue);

        } catch (JiraException e) {
            e.printStackTrace();
        }
    }
}