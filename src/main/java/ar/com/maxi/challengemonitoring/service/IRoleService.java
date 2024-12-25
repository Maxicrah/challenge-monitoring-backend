package ar.com.maxi.challengemonitoring.service;

import ar.com.maxi.challengemonitoring.model.Role;

public interface IRoleService {

    Role findByName(String name);
}
