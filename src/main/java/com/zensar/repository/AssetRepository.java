package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {

}
