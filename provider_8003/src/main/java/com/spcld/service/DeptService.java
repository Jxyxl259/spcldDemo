package com.spcld.service;

import java.util.List;

import com.spcld.entity.Dept;

public interface DeptService
{
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
