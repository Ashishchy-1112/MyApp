import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    email: "",
    password: ""
  });

  function handleChange(e) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  // LOGIN FUNCTION
  async function handleLogin() {
    try {
      const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(form)
      });

      if (!response.ok) {
        alert("Email or Password is incorrect!");
        return;
      }

      const data = await response.json();

      // Save token + email + id
      localStorage.setItem("token", data.token);
      localStorage.setItem("email", data.email);
      localStorage.setItem("id", data.id);

      alert("Login successful!");

      navigate("/home");

    } catch (error) {
      console.error("Error:", error);
      alert("Something went wrong!");
    }
  }

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="p-4 shadow-lg rounded-3" style={{ width: "350px", background: "white" }}>
        <h3 className="text-center mb-4">Login</h3>

        {/* FIXED INPUTS */}
        <input
          type="email"
          name="email"
          value={form.email}
          onChange={handleChange}
          className="form-control mb-3"
          placeholder="Email"
        />

        <input
          type="password"
          name="password"
          value={form.password}
          onChange={handleChange}
          className="form-control mb-3"
          placeholder="Password"
        />

        {/* FIXED BUTTON */}
        <button
          className="btn btn-primary w-100 mb-2"
          onClick={handleLogin}
        >
          Login
        </button>

        <p className="text-center">
          Don't have an account?{" "}
          <span
            onClick={() => navigate("/signup")}
            style={{ color: "blue", cursor: "pointer" }}
          >
            Sign Up
          </span>
        </p>
      </div>
    </div>
  );
}
