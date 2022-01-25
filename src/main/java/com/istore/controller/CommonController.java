package com.istore.controller;

import com.istore.common.ApiResponse;
import com.istore.dto.LoginRequestDTO;
import com.istore.dto.SignUpRequestDTO;
import com.istore.service.ProductService;
import com.istore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CommonController {

    // ---------------Login Controller Starts---------------

    @Autowired
    private UserService userService;

    // @Autowired
    // private AuthenticationManager authenticationManager;

    // @Autowired
    // private JwtUtil jwtUtil;

    @PostMapping("/signup") // To Get SignUp
    public ApiResponse getSignUp(@RequestBody SignUpRequestDTO newUserData) {
        return userService.getSignUp(newUserData);
    }

    @PostMapping("/login") // To Get Login
    public ApiResponse getLogin(@RequestBody LoginRequestDTO userData) {
        return userService.getLogin(userData);
    }

    // @PostMapping("/authenticate")
    // public ApiResponse getAuthenticated(@RequestBody LoginRequestDTO userData)
    // throws Exception {
    // try {
    // authenticationManager
    // .authenticate(new UsernamePasswordAuthenticationToken(userData.getEmail(),
    // userData.getPassword()));
    // } catch (BadCredentialsException e) {
    // throw new Exception("Incorrect Email or Password", e);
    // }

    // User user = (User) userService.loadUserByUsername(userData.getEmail());
    // String jwt = jwtUtil.generateToken(user);

    // ApiResponse apiResponse = new ApiResponse();

    // LoginData loginData = new LoginData();
    // loginData.setToken(jwt);
    // loginData.setUser(new LoginResponseDTO(user.getId(), user.getRole()));

    // apiResponse.setStatus(HttpStatus.OK.value());
    // apiResponse.setData(loginData);
    // return apiResponse;
    // }

    // ---------------Login Controller Ends---------------

    // ---------------Product Controller Starts---------------

    @Autowired
    private ProductService productService;

    @GetMapping("/products") // To Get All the Products
    public ApiResponse getAllProducts(@RequestParam(value = "isAdmin", required = false) boolean isAdmin) {
        return productService.getAllProducts(isAdmin);
    }

    @GetMapping("/products/{id}") // To Get Particular Product
    public ApiResponse getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    // ---------------Product Controller Ends---------------
}
