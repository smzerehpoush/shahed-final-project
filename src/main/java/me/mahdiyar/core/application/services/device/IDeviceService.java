package me.mahdiyar.core.application.services.device;

import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.models.dto.device.requests.SaveDeviceDataRequestDto;

public interface IDeviceService {
    void saveDeviceData(SaveDeviceDataRequestDto request) throws ApplicationException;
}
