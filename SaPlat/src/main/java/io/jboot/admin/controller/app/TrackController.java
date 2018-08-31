package io.jboot.admin.controller.app;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.admin.base.common.BaseStatus;
import io.jboot.admin.base.common.RestResult;
import io.jboot.admin.base.exception.BusinessException;
import io.jboot.admin.base.interceptor.NotNullPara;
import io.jboot.admin.base.rest.datatable.DataTable;
import io.jboot.admin.base.web.base.BaseController;
import io.jboot.admin.service.api.*;
import io.jboot.admin.service.entity.model.*;
import io.jboot.admin.service.entity.status.system.ProjectStatus;
import io.jboot.admin.support.auth.AuthUtils;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.web.controller.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * -----------------------------
 *
 * @author LiuChuanJin
 * @version 2.0
 *          -----------------------------
 * @date 10:05 2018/8/4
 */
@RequestMapping("/app/track")
public class TrackController extends BaseController {

    @JbootrpcService
    private FileProjectService fileProjectService;

    @JbootrpcService
    private ProjectService projectService;

    @JbootrpcService
    private UserService userService;

    @JbootrpcService
    private ProjectFileTypeService projectFileTypeService;

    @JbootrpcService
    private FilesService filesService;

    @JbootrpcService
    private UserRoleService userRoleService;

    @JbootrpcService
    private RoleService roleService;

    @JbootrpcService
    private ProjectAssTypeService projectAssTypeService;

    @JbootrpcService
    private FacAgencyService facAgencyService;

    public void index() {

    }

    /**
     * 风险跟踪管理登记表-表格渲染
     */
    @NotNullPara({"id", "fileTypeID"})
    public void fileTable() {
        Long id = getParaToLong("id");
        Long fileTypeID = getParaToLong("fileTypeID");
        FileProject model = new FileProject();
        model.setFileTypeID(fileTypeID);
        model.setProjectID(id);
        model.setIsEnable(true);
        int pageNumber = getParaToInt("pageNumber", 1);
        int pageSize = getParaToInt("pageSize", 30);
        Page<FileProject> page = fileProjectService.findPage(model, pageNumber, pageSize);
        for (int i = 0; i < page.getList().size(); i++) {
            page.getList().get(i).setCreateUserName(userService.findById(page.getList().get(i).getCreateUserID()).getName());
            page.getList().get(i).setName(projectFileTypeService.findById(page.getList().get(i).getFileTypeID()).getName());
        }
        renderJson(new DataTable<FileProject>(page));
    }

    /**
     * 风险跟踪管理登记表-项目-页面
     */
    public void toRiskTrack() {
        render("riskTrack.html");
    }

    /**
     * 风险跟踪管理登记表-页面
     */
    @NotNullPara("projectID")
    public void toRiskTrackManagement() {
        Long projectFileTypeID = projectFileTypeService.findByName("风险跟踪管理登记表").getId();
        List<UserRole> list = userRoleService.findListByUserId(AuthUtils.getLoginUser().getId());
        boolean mRole = false, fRole = false;
        for (UserRole u : list) {
            if (roleService.findById(u.getRoleID()).getName().equals("管理机构")) {
                mRole = true;
            } else if (roleService.findById(u.getRoleID()).getName().equals("服务机构")) {
                fRole = true;
            }
        }
        setAttr("mRole", mRole).setAttr("fRole", fRole).
                setAttr("projectFileTypeID", projectFileTypeID).setAttr("projectID", getParaToLong("projectID")).render("riskTrackingManagement.html");
    }

    /**
     * 风险跟踪管理登记表-删除
     */
    @NotNullPara({"id", "fileID"})
    public void deleteRiskTrackingMessage() {
        FileProject fileProject = fileProjectService.findById(getParaToLong("id"));
        Files files = filesService.findById(getParaToLong("fileID"));
        if (files != null && fileProject != null) {
            fileProject.setIsEnable(false);
            files.setIsEnable(false);
            if (!fileProjectService.update(fileProject, files)) {
                renderJson(RestResult.buildError("删除失败"));
                throw new BusinessException("删除失败");
            }
        }
    }

    /**
     * 跟踪资料移交表-页面
     */
    public void toTrackData() {
        Long projectFileTypeID = projectFileTypeService.findByName("跟踪资料移交表").getId();
        List<UserRole> list = userRoleService.findListByUserId(AuthUtils.getLoginUser().getId());
        boolean mRole = false, fRole = false;
        for (UserRole u : list) {
            if (roleService.findById(u.getRoleID()).getName().equals("管理机构")) {
                mRole = true;
            } else if (roleService.findById(u.getRoleID()).getName().equals("服务机构")) {
                fRole = true;
            }
        }
        setAttr("mRole", mRole).setAttr("fRole", fRole).
                setAttr("projectFileTypeID", projectFileTypeID).render("trackingDataTransfer.html");
    }

    /**
     * 备案资料移交表-页面
     */
    public void toRecordData() {
        Long projectFileTypeID = projectFileTypeService.findByName("备案资料移交表").getId();
        List<UserRole> list = userRoleService.findListByUserId(AuthUtils.getLoginUser().getId());
        boolean mRole = false, fRole = false;
        for (UserRole u : list) {
            if (roleService.findById(u.getRoleID()).getName().equals("管理机构")) {
                mRole = true;
            } else if (roleService.findById(u.getRoleID()).getName().equals("服务机构")) {
                fRole = true;
            }
        }
        setAttr("mRole", mRole).setAttr("fRole", fRole).
                setAttr("projectFileTypeID", projectFileTypeID).render("recordDataTransfer.html");
    }
    /**
     *  项目列表
     */
    @Before(GET.class)
    public void projectList(){
        BaseStatus baseStatus=new BaseStatus() {};
        ProjectAssType model = new ProjectAssType();
        model.setIsEnable(true);
        List<ProjectAssType> PaTypeList = projectAssTypeService.findAll(model);
        if(PaTypeList != null) {
            for (ProjectAssType item :
                    PaTypeList) {
                baseStatus.add(item.getId().toString(), item.getName());
            }
        }
        setAttr("PaTypeNameList",baseStatus);
        render("projectList.html");
    }

    @Before(GET.class)
    @NotNullPara({"pageNumber","pageSize"})
    public void projectListTableData(){
        User loginUser = AuthUtils.getLoginUser();
        int pageNumber = getParaToInt("pageNumber", 1);
        int pageSize = getParaToInt("pageSize", 30);

        ProjectUndertake projectUndertake = new ProjectUndertake();

        FacAgency facAgency = facAgencyService.findByOrgId(loginUser.getUserID());//找到组织机构对应的服务机构信息
        if (facAgency != null) {
            projectUndertake.setFacAgencyID(facAgency.getId());
        }
        projectUndertake.setStatus(Integer.valueOf(ProjectStatus.CHECKED));
        Page<Project> page = projectService.findPageBySql(projectUndertake, pageNumber, pageSize);
        if(page != null) {
            for (int i = 0; i < page.getList().size(); i++) {
                ProjectFileType projectFileType = projectFileTypeService.findByName("备案资料移交表");
                FileProject fileProject = fileProjectService.findByFileTypeIdAndProjectId(projectFileType.getId(), page.getList().get(i).getId());

                if (fileProject != null) {
                    page.getList().get(i).setIsBackRecordUpLoad(true);
                    page.getList().get(i).setBackRecordFileID(fileProject.getFileID());
                } else {
                    page.getList().get(i).setIsBackRecordUpLoad(false);
                }
            }
            renderJson(new DataTable<Project>(page));
        }
        else{
            renderJson(new DataTable<Project>(new Page<Project>()));
        }
    }

    /**
     *  项目列表
     */
    @Before(GET.class)
    public void projectRiskList(){
        BaseStatus baseStatus=new BaseStatus() {};
        ProjectAssType model = new ProjectAssType();
        model.setIsEnable(true);
        List<ProjectAssType> PaTypeList = projectAssTypeService.findAll(model);
        if(PaTypeList != null) {
            for (ProjectAssType item :
                    PaTypeList) {
                baseStatus.add(item.getId().toString(), item.getName());
            }
        }
        setAttr("PaTypeNameList",baseStatus);
        render("projectRiskList.html");
    }

    @Before(GET.class)
    @NotNullPara({"pageNumber","pageSize"})
    public void projectRiskListTableData(){
        User loginUser = AuthUtils.getLoginUser();
        int pageNumber = getParaToInt("pageNumber", 1);
        int pageSize = getParaToInt("pageSize", 30);

        ProjectUndertake projectUndertake = new ProjectUndertake();

        FacAgency facAgency = facAgencyService.findByOrgId(loginUser.getUserID());//找到组织机构对应的服务机构信息
        if (facAgency != null) {
            projectUndertake.setFacAgencyID(facAgency.getId());
        }
        projectUndertake.setStatus(Integer.valueOf(ProjectStatus.CHECKED));
        Page<Project> page = projectService.findPageBySql(projectUndertake, pageNumber, pageSize);
        if(page == null) {
            renderJson(new DataTable<Project>(new Page<Project>()));
        }
        else{
            renderJson(new DataTable<Project>(page));
        }
    }

    /**
     * 备案文件上传页面
     */
    @NotNullPara({"projectId"})
    public void fileUploading() {
        Long fileTypeId = projectFileTypeService.findByName("备案资料移交表").getId();
        setAttr("projectId", getParaToLong("projectId")).setAttr("fileTypeId", fileTypeId).render("fileUploading.html");
    }

    /**
     * 项目文件关联
     */
    @NotNullPara({"fileId", "projectId", "fileTypeId"})
    public void upFile() {
        User user = AuthUtils.getLoginUser();
        FileProject model = fileProjectService.findByProjectIDAndFileTypeID(getParaToLong("projectId"), getParaToLong("fileTypeId"));
        if (model == null) {
            model = new FileProject();
            model.setProjectID(getParaToLong("projectId"));
            model.setFileTypeID(getParaToLong("fileTypeId"));
            model.setCreateTime(new Date());
            model.setCreateUserID(user.getId());

        } else {
            Files files = filesService.findById(model.getFileID());
            if (files != null) {
                files.setIsEnable(false);
                if (!filesService.update(files)) {
                    renderJson(RestResult.buildError("文件禁用失败"));
                    throw new BusinessException("文件禁用失败");
                }
            }
        }
        model.setFileID(getParaToLong("fileId"));
        model.setLastAccessTime(new Date());
        model.setLastUpdateUserID(user.getId());

        if (!fileProjectService.saveOrUpdate(model)) {
            renderJson(RestResult.buildError("上传失败"));
            throw new BusinessException("上传失败");
        } else {
            Files files = filesService.findById(getParaToLong("fileId"));
            files.setIsEnable(true);
            if (!filesService.update(files)) {
                renderJson(RestResult.buildError("文件启用失败"));
                throw new BusinessException("文件启用失败");
            }
        }
        renderJson(RestResult.buildSuccess());
    }
}

