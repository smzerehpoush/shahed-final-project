package me.mahdiyar.presentation.controllers;

import lombok.RequiredArgsConstructor;
import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.device.requests.CreateDeviceRequestDto;
import me.mahdiyar.core.application.models.dto.device.requests.UpdateDeviceRequestDto;
import me.mahdiyar.core.application.models.dto.device.responses.CreateDeviceResponseDto;
import me.mahdiyar.core.application.models.dto.device.responses.GetUserDeviceDataResponseDto;
import me.mahdiyar.core.application.models.dto.device.responses.GetUserDevicesResponseDto;
import me.mahdiyar.core.application.models.dto.device.responses.UpdateDeviceResponseDto;
import me.mahdiyar.core.application.services.device.DeviceServiceMapper;
import me.mahdiyar.core.application.services.device.IDeviceService;
import me.mahdiyar.core.application.services.userDevice.IUserDeviceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user/{userId}/devices/")
public class DeviceController {
    private final IDeviceService deviceService;
    private final IUserDeviceService userDeviceService;
    private final DeviceServiceMapper deviceServiceMapper;

    @PostMapping
    public CreateDeviceResponseDto createDevice(@PathVariable long userId, @RequestBody CreateDeviceRequestDto request) throws ApplicationException {
        var device = deviceService.createDevice(userId, request);
        return deviceServiceMapper.toCreateDeviceResponseDto(device);
    }

    @GetMapping
    public GetUserDevicesResponseDto getUserDevices(@PathVariable long userId) throws ApplicationException {
        var devices = deviceService.getUserDevices(userId);
        return deviceServiceMapper.toGetUserDevicesResponseDto(devices);
    }


    @PutMapping("{deviceId}")
    public UpdateDeviceResponseDto updateDevice(@PathVariable long userId, @PathVariable long deviceId, @RequestBody UpdateDeviceRequestDto request) throws ApplicationException {
        var device = deviceService.updateDevice(userId, deviceId, request);
        return deviceServiceMapper.toUpdateDeviceResponseDto(device);
    }

    @DeleteMapping("{deviceId}")
    public ServiceResponse deleteDevice(@PathVariable long userId, @PathVariable long deviceId) throws ApplicationException {
        deviceService.deleteDevice(userId, deviceId);
        return ServiceResponse.success();
    }


    @GetMapping("{deviceId}/data")
    public GetUserDeviceDataResponseDto getUserDevices(@PathVariable long userId, @PathVariable long deviceId) throws ApplicationException {
        var deviceDataList = userDeviceService.getUserDeviceDataList(userId, deviceId);
        return deviceServiceMapper.toGetUserDeviceDataResponseDto(deviceDataList);
    }
}
