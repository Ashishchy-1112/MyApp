import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Signup() {
  const [showPassword, setShowPassword] = useState(false);
  const navigate = useNavigate();

  return (
    <div
      className="d-flex justify-content-center align-items-center vh-100"
      style={{ background: "#f5f5f5" }}
    >
      <div className="p-4 shadow rounded" style={{ width: "360px", background: "white" }}>
        <h3 className="text-center mb-4 fw-bold">Create Account</h3>

        <input type="text" className="form-control mb-3 p-2" placeholder="Full Name" />
        <input type="email" className="form-control mb-3 p-2" placeholder="Email" />
        <input type="text" className="form-control mb-3 p-2" placeholder="Phone Number" />

        <div className="mb-3 position-relative">
          <input
            type={showPassword ? "text" : "password"}
            className="form-control p-2"
            placeholder="Password"
          />
          <i
            className={`bi ${showPassword ? "bi-eye-slash" : "bi-eye"} position-absolute`}
            style={{ right: "12px", top: "12px", cursor: "pointer" }}
            onClick={() => setShowPassword(!showPassword)}
          ></i>
        </div>

        <button className="btn btn-primary w-100 p-2">Sign Up</button>

        <p className="text-center mt-3">
          Already have an account?{" "}
          <span
            onClick={() => navigate("/login")}
            style={{ color: "blue", cursor: "pointer" }}
          >
            Login
          </span>
        </p>
      </div>
    </div>
  );
}
