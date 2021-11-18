package me.mahdiyar.presentation.controllers;

import lombok.RequiredArgsConstructor;
import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.device.requests.SaveDeviceDataRequestDto;
import me.mahdiyar.core.application.services.device.IDeviceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/device/")
@RequiredArgsConstructor
public class DeviceController {
    private final IDeviceService deviceService;

    @PostMapping("sendData")
    public ServiceResponse SaveDeviceData(@RequestBody SaveDeviceDataRequestDto request) throws ApplicationException {
        deviceService.saveDeviceData(request);
        return ServiceResponse.success();
    }

}
