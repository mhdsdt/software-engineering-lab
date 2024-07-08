import { defineConfig } from 'vite'

const base = process.env.DEPLOY_ENV === 'staging' ? '/software-engineering-lab/stg-exp-1/' : '/software-engineering-lab/exp-1/'

export default defineConfig({
  base,
  build: {
    outDir: process.env.DEPLOY_ENV === 'staging' ? 'dist/stg-exp-1' : 'dist/exp-1'
  }
})
