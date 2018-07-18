package io.jboot.admin.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.admin.service.api.FilesService;
import io.jboot.admin.service.entity.model.Files;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
public class FilesServiceImpl extends JbootServiceBase<Files> implements FilesService {

}