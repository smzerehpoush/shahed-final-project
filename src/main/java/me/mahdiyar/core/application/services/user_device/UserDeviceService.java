package me.mahdiyar.core.application.services.user_device;

import lombok.RequiredArgsConstructor;
import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.exceptions.ForbiddenActionException;
import me.mahdiyar.core.application.services.device.IDeviceService;
import me.mahdiyar.core.application.services.user.IUserService;
import me.mahdiyar.core.domain.entities.DeviceDataEntity;
import me.mahdiyar.core.domain.repositories.DeviceDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserDeviceService implements IUserDeviceService {
    private final IUserService userService;
    private final IDeviceService deviceService;
    private final DeviceDataRepository deviceDataRepository;

    public List<DeviceDataEntity> getUserDeviceDataList(long userId, long deviceId) throws ApplicationException {
        var user = userService.getUser(userId);
        var device = deviceService.getDevice(deviceId);
        if (!Objects.equals(device.getUser(), user)) {
            throw new ForbiddenActionException();
        }
        return deviceDataRepository.findAllByDeviceId(deviceId);
    }
}
