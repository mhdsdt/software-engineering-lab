/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: '#B83CFF',
        secondary: '#41D1FF',
      },
    },
  },
  plugins: [],
}

