module.exports = {
  content: [
    "./modules/**/*.{js,jsx,ts,tsx}",
    "../node_modules/flowbite-react/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {},
  },
  plugins: [require("flowbite/plugin")],
};
