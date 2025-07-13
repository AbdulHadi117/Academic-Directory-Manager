package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Listener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // Unimplemented method
    }

    /**
     * Refresh the course list by clearing the model and adding new courses from
     * the selected semester.
     *
     * @param gui the GUI object
     */
    public void refreshList(GUI gui) {
        // Clear the model
        gui.getCourseListModel().clear();
        // Get the selected semester
        String semester = (String) gui.getSemesterComboBox().getSelectedItem();
        // No Semester is selected, do nothing
        if (semester == null) {
            return;
        }
        // Get the semester folder
        File semesterFolder = new File(Utility.getBASE_DIR(), semester);
        // List all the courses in the semester folder
        File[] courses = semesterFolder.listFiles(File::isDirectory);
        if (courses != null) {
            // Add each course to the model
            for (File course : courses) {
                gui.getCourseListModel().addElement(course.getName());
            }
        }
    }    
    
}
