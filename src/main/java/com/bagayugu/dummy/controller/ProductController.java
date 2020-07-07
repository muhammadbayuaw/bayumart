package com.bagayugu.dummy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bagayugu.dummy.request.ProductRequest;
import com.bagayugu.dummy.response.BaseResponse;
import com.bagayugu.dummy.response.DetailProductResponse;
import com.bagayugu.dummy.service.ProductService;
import com.bagayugu.dummy.util.UrlUtil;

@RestController
@RequestMapping(path = UrlUtil.V1.PRODUCTS)
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/{id}")
	public ResponseEntity<DetailProductResponse> findById(@PathVariable String id){
		DetailProductResponse response = productService.findById(id);
		return new ResponseEntity<DetailProductResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DetailProductResponse> save(@Valid @RequestBody ProductRequest request){
		DetailProductResponse response = productService.create(request);
		return new ResponseEntity<DetailProductResponse>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DetailProductResponse> update(@PathVariable String id, 
			@RequestBody ProductRequest request){
		DetailProductResponse response = productService.update(id, request);
		return new ResponseEntity<DetailProductResponse>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<BaseResponse> delete(@PathVariable String id){
		BaseResponse response = productService.delete(id);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
