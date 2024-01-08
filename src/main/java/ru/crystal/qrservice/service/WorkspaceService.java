package ru.crystal.qrservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crystal.qrservice.database.model.WorkSpace;
import ru.crystal.qrservice.repository.WorkspaceRepository;

import java.util.List;

/**
 * @project QRService
 * ©Crystal2033
 * @date 29/11/2023
 */
@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    @Autowired
    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public List<WorkSpace> getWorkspaces(){
        return workspaceRepository.findAll();
    }
}
