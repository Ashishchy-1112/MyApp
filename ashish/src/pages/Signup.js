import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Signup() {
  const [showPassword, setShowPassword] = useState(false);
  const navigate = useNavigate();

  const [form, setForm] = useState({
    name: "",
    email: "",
    phone: "",
    password: ""
  });

  // Handle input change
  function handleChange(e) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  // Submit form to backend
  async function handleSignup() {
    try {
      const response = await fetch("http://localhost:8080/user/signup", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(form)
      });

      if (!response.ok) {
        alert("Signup failed!");
        return;
      }

      const data = await response.json();
      alert("Signup successful!");
      navigate("/login");

    } catch (error) {
      console.error("Error:", error);
      alert("Something went wrong!");
    }
  }

  return (
    <div
      className="d-flex justify-content-center align-items-center vh-100"
      style={{ background: "#f5f5f5" }}
    >
      <div className="p-4 shadow rounded" style={{ width: "360px", background: "white" }}>
        <h3 className="text-center mb-4 fw-bold">Create Account</h3>

        <input
          type="text"
          name="name"
          className="form-control mb-3 p-2"
          placeholder="Full Name"
          onChange={handleChange}
        />

        <input
          type="email"
          name="email"
          className="form-control mb-3 p-2"
          placeholder="Email"
          onChange={handleChange}
        />

        <input
          type="text"
          name="phone"
          className="form-control mb-3 p-2"
          placeholder="Phone Number"
          onChange={handleChange}
        />

        <div className="mb-3 position-relative">
          <input
            type={showPassword ? "text" : "password"}
            name="password"
            className="form-control p-2"
            placeholder="Password"
            onChange={handleChange}
          />
          <i
            className={`bi ${showPassword ? "bi-eye-slash" : "bi-eye"} position-absolute`}
            style={{ right: "12px", top: "12px", cursor: "pointer" }}
            onClick={() => setShowPassword(!showPassword)}
          ></i>
        </div>

        <button className="btn btn-primary w-100 p-2" onClick={handleSignup}>
          Sign Up
        </button>

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
