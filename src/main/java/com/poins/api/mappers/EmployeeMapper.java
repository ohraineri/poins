package com.poins.api.mappers;

import com.poins.api.dtos.EmployeeDTO;
import com.poins.api.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    Employee toEntity(EmployeeDTO employeeDTO);
}
