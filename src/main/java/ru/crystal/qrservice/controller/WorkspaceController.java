package ru.crystal.qrservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.crystal.qrservice.database.model.WorkSpace;
import ru.crystal.qrservice.service.WorkspaceService;

import java.util.List;

/**
 * @project QRService
 * ©Crystal2033
 * @date 29/11/2023
 */
@RestController
@RequestMapping("/api/workspaces")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    public List<WorkSpace> getWorkspaces(){
        return workspaceService.getWorkspaces();
    }
}
