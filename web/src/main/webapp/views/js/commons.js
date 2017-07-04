/**
 * Created by liujin on 5/3/17.
 */
function getProjectName() {
    var pathName = location.pathname;
    var projectName = pathName.substring(0, pathName.substr(1).indexOf("/")+1);
    return projectName;
}