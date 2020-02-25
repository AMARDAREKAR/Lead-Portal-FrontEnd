package com.yoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoan.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {

}
